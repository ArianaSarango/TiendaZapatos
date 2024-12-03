from flask import Blueprint, abort, request, render_template, redirect, url_for # type: ignore

router = Blueprint('router', __name__)

@router.route('/')
def home():
    return render_template('index.html')

@router.route('/checkout')
def checkout():
    return render_template('checkout.html')

@router.route('/cart')
def cart():
    return render_template('cart.html')
