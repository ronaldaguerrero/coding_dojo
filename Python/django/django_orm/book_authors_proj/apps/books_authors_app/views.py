# views in first app folder
from django.shortcuts import render, redirect
from .models import Book,Author
# show all of the data from a table
def index(request):
	context = {
		"books": Book.objects.all()
	}
	return render(request, "books_authors_app/index.html", context)

# creates a new book
def create(request):
	print('*' * 100)
	Book.objects.create(title=request.POST['title'], desc=request.POST['desc'])
	return redirect('/')

def author(request):
	context = {
		"authors": Author.objects.all()
	}
	return render(request, "books_authors_app/author.html", context)

def createA(request):
	Author.objects.create(first_name=request.POST['fn'], last_name=request.POST['ln'], notes=request.POST['notes'])
	return redirect('/author')

def view(request, my_val):
	context = {
		"book": Book.objects.get(id=my_val),
		"authors": Book.objects.get(id=my_val).authors.all(),
		"all_a": Author.objects.all(),
	}
	return render(request, 'books_authors_app/books.html', context)

def viewA(request, my_val):
	context = {
		"author": Author.objects.get(id=my_val),
		"books": Author.objects.get(id=my_val).books.all(),
		"all_b": Book.objects.all(),
	}
	return render(request, 'books_authors_app/authors.html', context)

def linkA(request, my_val):
	context = {
		"book": Book.objects.get(id=my_val).authors.add(Author.objects.get(id=request.POST['authorid']))
	}
	return redirect('/')

def linkB(request, my_val):
	context = {
		"author": Author.objects.get(id=my_val).books.add(Book.objects.get(id=request.POST['bookid']))
	}
	return redirect('/author')
	# to redirect to an author id = '/author'+str(my_val)

# sample function to create a new book
def new(request):
	return render(request, 'books_authors_app/new.html')


# def books(request):
# 	context = {
# 		"book": Book.object.get(id=id)
# 	}


