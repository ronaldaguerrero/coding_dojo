from django.conf.urls import url
from . import views
                    
urlpatterns = [
    url(r'^$', views.index), # similar to @app.route('/') in flask
    url(r'^new$', views.new),
    url(r'^other$', views.other),
]