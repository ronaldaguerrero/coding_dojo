### url in apps folder for functions ###
from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^reset$', views.reset),
    url(r'^process_money$', views.process_money),
]