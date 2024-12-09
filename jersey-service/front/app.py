from flask import Flask # type: ignore
def create_app():
    app = Flask(__name__, instance_relative_config=False)
    with app.app_context():
        from routes.route import router 
        app.register_blueprint(router)
    return app