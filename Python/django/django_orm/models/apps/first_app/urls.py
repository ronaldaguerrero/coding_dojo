### app url ##
from django.conf.urls import url
from . import views
                    
urlpatterns = [
    url(r'^$', views.index), # similar to @app.route('/') in flask
]