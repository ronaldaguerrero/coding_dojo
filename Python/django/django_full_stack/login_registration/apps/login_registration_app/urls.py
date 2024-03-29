from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.register_form),
    url(r'^register$', views.register_form),
    url(r'^users$', views.register_user),
    url(r'^login$', views.login),
    url(r'^success$', views.success),
    url(r'^logout$', views.logout),
]
