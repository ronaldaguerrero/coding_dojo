from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.register_form),
    url(r'^users$', views.register_user),
    url(r'^dashboard$', views.dashboard),
    url(r'^trips/new$', views.trip_new),
    url(r'^create_trip$', views.add),
    url(r'^edit_trip/(?P<my_val>\d+)$', views.edit),
    url(r'^update/(?P<my_val>\d+)$', views.update),
    url(r'^trips/(?P<my_val>\d+)$', views.view),
    url(r'^remove/(?P<my_val>\d+)$', views.remove),
    url(r'^login$', views.login),
    url(r'^logout$', views.logout),
]
