### app url ##
from django.conf.urls import url
from . import views
                    
urlpatterns = [
    url(r'^$', views.all_shows), # similar to @app.route('/') in flask
    url(r'^addpage$', views.addpage),
    url(r'^addshow$', views.add),
    url(r'^show/(?P<my_val>\d+)$', views.show),
    url(r'^shows/(?P<my_val>\d+)/edit$', views.edit),
    url(r'^allshows$', views.all_shows),
    url(r'^update/(?P<my_val>\d+)$', views.update),
    url(r'^delete/(?P<my_val>\d+)$', views.delete),
]