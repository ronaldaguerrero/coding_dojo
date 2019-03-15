### app url ##
from django.conf.urls import url
from . import views
                    
urlpatterns = [
	url(r'^linkB/(?P<my_val>\d+)$', views.linkB), 
	url(r'^link/(?P<my_val>\d+)$', views.linkA), 
    url(r'^viewA/(?P<my_val>\d+)$', views.viewA),
    url(r'^view/(?P<my_val>\d+)$', views.view),
    url(r'^author/new$', views.createA), 
    url(r'^books/create$', views.create),
    url(r'^books/new$', views.new), # sample html
    url(r'^author$', views.author),
    url(r'^$', views.index), # similar to @app.route('/') in flask
]