### project url ###
from django.conf.urls import url, include	# added an import!
# from django.contrib import admin              # comment out, or just delete
urlpatterns = [
	url(r'^viewA', include('apps.books_authors_app.urls')),
	url(r'^view', include('apps.books_authors_app.urls')),
	url(r'^books/create/', include('apps.books_authors_app.urls')),
	url(r'^books/new/', include('apps.books_authors_app.urls')),
	url(r'^author/', include('apps.books_authors_app.urls')),
    url(r'^', include('apps.books_authors_app.urls')),	# use your app_name here
]