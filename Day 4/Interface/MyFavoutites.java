public class MyFavoutites extends ParentFavourites implements Favourites{
	
	//Inference
	public void favouriteFruit(){
		System.out.println("Mango");
	}

	public void favouriteMovie(){
		System.out.println("Intestellar");
	}

	public void favouriteSubject(){
		System.out.println("Maths");
	}

	public void favouriteIceCream(){		//If this (or atleast any one) is removed we get error
		System.out.println("Naturals");
	}

	//From ParentClass
	public void abc(){
		super.parentFavouritesMovie();
		super.parentFavouritesSubject();
	}

	public static void main(String[] args) {
		MyFavoutites fav = new MyFavoutites();

		fav.favouriteFruit();
		fav.favouriteMovie();
		fav.favouriteSubject();
		fav.favouriteIceCream();

		fav.abc();
	}

}