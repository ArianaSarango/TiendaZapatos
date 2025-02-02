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
