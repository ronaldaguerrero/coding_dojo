### app url, any changes here will need to exist in views ##
from django.conf.urls import url
from . import views
                    
urlpatterns = [
    url(r'^$', views.index), # similar to @app.route('/') in flask
    url(r'^newone$', views.newone),
    url(r'^(?P<my_val>\d+)$', views.show), # ?p = starts capture group
    url(r'^(?P<my_val>\d+)/edit$', views.edit), 
    url(r'^(?P<my_val>\d+)/delete$', views.delete),
    url(r'^submit_form$', views.submit_form),
]