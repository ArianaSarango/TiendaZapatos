from flask import Blueprint, render_template, request, redirect, url_for, flash
import json

router = Blueprint('router', __name__)

# Rutas de los archivos JSON
PERSONAS_FILE = "C:\\Users\\patri\\Downloads\\TiendaZapatos\\jersey-service\\Bakend\\media\\personas.json"
USUARIOS_FILE = "C:\\Users\\patri\\Downloads\\TiendaZapatos\\jersey-service\\Bakend\media\\usuarios.json"

# Funciones auxiliares para manipular archivos JSON
def cargar_datos(file_path):
    try:
        with open(file_path, 'r') as file:
            return json.load(file)
    except FileNotFoundError:
        return []
    except json.JSONDecodeError:
        return []

def guardar_datos(file_path, data):
    try:
        with open(file_path, 'w') as file:
            json.dump(data, file, indent=4)
    except Exception as e:
        print(f"Error al guardar datos: {e}")

# CRUD para personas
@router.route('/')
def home():
    personas = cargar_datos(PERSONAS_FILE)
    usuarios = cargar_datos(USUARIOS_FILE)
    return render_template('index.html', personas=personas, usuarios=usuarios)


@router.route('/persona/agregar', methods=['GET', 'POST'])
def agregar_persona():
    if request.method == 'POST':
        try:
            personas = cargar_datos(PERSONAS_FILE)
            nueva_persona = {
                "id": len(personas) + 1,
                "nombre": request.form['nombre'],
                "apellido": request.form['apellido'],
                "tipoIdentificacion": request.form['tipoIdentificacion'],
                "numeroIdentificacion": request.form['numeroIdentificacion'],
                "direccion": request.form['direccion'],
                "telefono": request.form['telefono']
            }
            personas.append(nueva_persona)
            guardar_datos(PERSONAS_FILE, personas)
            flash("Persona agregada exitosamente", "success")
            return redirect(url_for('router.home'))
        except Exception as e:
            flash(f"Error: {e}", "error")
    return render_template('agregar_persona.html')

@router.route('/persona/modificar/<int:id>', methods=['GET', 'POST'])
def modificar_persona(id):
    personas = cargar_datos(PERSONAS_FILE)
    persona = next((p for p in personas if p['id'] == id), None)
    if not persona:
        flash("Persona no encontrada", "error")
        return redirect(url_for('router.home'))

    if request.method == 'POST':
        try:
            persona.update({
                "nombre": request.form['nombre'],
                "apellido": request.form['apellido'],
                "tipoIdentificacion": request.form['tipoIdentificacion'],
                "numeroIdentificacion": request.form['numeroIdentificacion'],
                "direccion": request.form['direccion'],
                "telefono": request.form['telefono']
            })
            guardar_datos(PERSONAS_FILE, personas)
            flash("Persona actualizada exitosamente", "success")
            return redirect(url_for('router.home'))
        except Exception as e:
            flash(f"Error: {e}", "error")

    return render_template('modificar_persona.html', persona=persona, personas=personas)

@router.route('/persona/eliminar/<int:id>', methods=['POST'])
def eliminar_persona(id):
    try:
        personas = cargar_datos(PERSONAS_FILE)
        personas = [p for p in personas if p['id'] != id]
        guardar_datos(PERSONAS_FILE, personas)
        flash("Persona eliminada exitosamente", "success")
    except Exception as e:
        flash(f"Error: {e}", "error")
    return redirect(url_for('router.home'))

# CRUD para usuarios

@router.route('/usuario/agregar', methods=['GET', 'POST'])
def agregar_usuario():
    if request.method == 'POST':
        try:
            usuarios = cargar_datos(USUARIOS_FILE)
            nuevo_usuario = {
                "id": len(usuarios) + 1,
                "usuario": request.form['usuario'],
                "password": request.form['password'],
                "email": request.form['email'],
                "rol": request.form['rol'],
                "estado": request.form['estado'],
            }
            usuarios.append(nuevo_usuario)
            guardar_datos(USUARIOS_FILE, usuarios)
            flash("Usuario agregado exitosamente", "success")
            return redirect(url_for('router.home'))
        except Exception as e:
            flash(f"Error: {e}", "error")
    return render_template('agregar_usuario.html')


@router.route('/usuario/modificar/<int:id>', methods=['GET', 'POST'])
def modificar_usuario(id):
    usuarios = cargar_datos(USUARIOS_FILE)
    usuario = next((u for u in usuarios if u['id'] == id), None)
    if not usuario:
        flash("Usuario no encontrado", "error")
        return redirect(url_for('router.home'))

    if request.method == 'POST':
        try:
            usuario.update({
                "usuario": request.form['usuario'],
                "password": request.form['password'],
                "email": request.form['email'],
                "rol": request.form['rol'],
                "estado": request.form['estado'],
            })
            guardar_datos(USUARIOS_FILE, usuarios)
            flash("Usuario actualizado exitosamente", "success")
            return redirect(url_for('router.home'))
        except Exception as e:
            flash(f"Error: {e}", "error")

    return render_template('modificar_usuario.html', usuario=usuario)


@router.route('/usuario/eliminar/<int:id>', methods=['POST'])
def eliminar_usuario(id):
    try:
        usuarios = cargar_datos(USUARIOS_FILE)
        personas = [p for p in personas if p['id'] != id]
        guardar_datos(USUARIOS_FILE, usuarios)
        flash("Usuario eliminado exitosamente", "success")
    except Exception as e:
        flash(f"Error: {e}", "error")
    return redirect(url_for('router.home'))


@router.route('/persona/eliminar/<int:id>', methods=['POST'])
def eliminar_persona(id):
    try:
        personas = cargar_datos(PERSONAS_FILE)
        personas = [p for p in personas if p['id'] != id]
        guardar_datos(PERSONAS_FILE, personas)
        flash("Persona eliminada exitosamente", "success")
    except Exception as e:
        flash(f"Error: {e}", "error")
    return redirect(url_for('router.home'))