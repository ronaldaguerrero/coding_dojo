from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^cars/new$', views.new),
    url(r'^cars/create$', views.create),
    url(r'^register$', views.register_form),
    url(r'^users$', views.register_user),
    url(r'^login$', views.login),
    url(r'^success$', views.success),
    url(r'^logout$', views.logout),
]
