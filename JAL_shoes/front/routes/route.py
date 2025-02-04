from flask import Blueprint, abort, request, render_template, redirect, url_for # type: ignore

router = Blueprint('router', __name__)

@router.route('/')
def home():
    return render_template('index.html')

# @router.route('/')
# def home():
#     return render_template('templateFirst.html')


@router.route('/checkout')
def checkout():
    return render_template('ModuloFactura/checkout.html')

@router.route('/order')
def order():
    return render_template('ModuloFactura/order.html')

# @router.route('/producto/df/save', methods=['POST'])
# def save_Dtfac():
#     headers = {'Content-Type': 'application/json'}
#     form = request.form
#     detalle = form["txtdetalle"][:-1]
#     lista = detalle.split(":")
#     details = []
#     for item in lista:
#         lista_aux = item.split(",")
#         details.append({"producto": lista_aux[0],"cantidadProductos": lista_aux[1],"prcUnidad": lista_aux[2], "prcTotal": (float(lista_aux[1]) * float(lista_aux[2]))})
#         #print(item)
#     #print(detalle)
#     dataF = {"device": form["device"], "vat": form["iva"][1], "subtotal": form["subtotal"][1:], "total": form["total"][1:], "details": details}
#     print(dataF)
#     r = requests.post("http://localhost:8086/api/factura/save", data=json.dumps(dataF), headers=headers)
#     dat = r.json()
#     if r.status_code == 200:
#         flash("Factura guardada con éxito", category="info")
#         return redirect(url_for('router.checkout'))
#     else:
#         flash(str(dat["data"]), category="error")
#         return redirect(url_for('router.order'))


@router.route('/producto/df/save', methods=['POST'])
def save_Dtfac():
    headers = {'Content-Type': 'application/json'}
    form = request.form
    
    try:
        detalle = form["txtdetalle"][:-1]  # Elimina el último carácter, ¿es necesario?
        lista = detalle.split(":")
        details = []

        for item in lista:
            lista_aux = item.split(",")
            details.append({
                "producto": lista_aux[0],
                "cantidadProductos": int(lista_aux[1]),  # Convertir cantidad a entero
                "prcUnidad": float(lista_aux[2]),  # Convertir precio unitario a float
                "prcTotal": round(float(lista_aux[1]) * float(lista_aux[2]), 2)  # Redondear a 2 decimales
            })

        # Convertir valores numéricos correctamente
        dataF = {
            "device": form["device"],
            "vat": float(form["iva"]),  # Se asume que `iva` ya es correcto
            "subtotal": float(form["subtotal"][1:]),  # Se elimina el primer carácter, ¿es un símbolo?
            "total": float(form["total"][1:]),  # Igual que subtotal
            "details": details
        }

        print("Datos enviados a la API:", dataF)

        r = requests.post("http://localhost:8086/api/factura/save", data=json.dumps(dataF), headers=headers)
        dat = r.json()

        if r.status_code == 200:
            flash("Factura guardada con éxito", category="info")
            return redirect(url_for('router.checkout'))
        else:
            flash(f"Error: {dat.get('data', 'Error desconocido')}", category="error")
            return redirect(url_for('router.order'))

    except Exception as e:
        flash(f"Error en la solicitud: {str(e)}", category="error")
        return redirect(url_for('router.order'))