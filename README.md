
# PopUps
This is simple and lightweight android library to make PopupMenu and ContextMenu with icon and beautiful UI 


[![](https://jitpack.io/v/tubagus216/PopUps.svg)](https://jitpack.io/#tubagus216/PopUps)

## Demo

![](https://github.com/tubagus216/PopUps/blob/main/art/WhatsApp%20Image%202022-02-16%20at%2023.35.34.jpeg)
![](https://github.com/tubagus216/PopUps/blob/main/art/WhatsApp%20Image%202022-02-16%20at%2023.35.33.jpeg)

Or Download [Demo Apk](https://github.com/tubagus216/PopUps/blob/main/art/PopupsExample.apk)

## Instalation

Add it in your root build.gradle at the end of repositories:
```
allprojects {
  repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency
```
dependencies {
	implementation 'com.github.tubagus216:PopUps:v0.1.0'
}
```


## Use It
```java
MenuBuilder builder = new Menu.Builder().build(); 
builder.addItem(new MenuItem("Android", R.drawable.ic_android)); //Normal
builder.addItem(new MenuItem("Share", R.drawable.ic_share, Color.BLUE)); //Colored
builder.addItem(new MenuItem("Android", R.drawable.ic_setting));
builder.addItem(new MenuItem("Share", R.drawable.ic_delete, Color.RED));

// View such as Button, TextView ListView etc.
PopUps.createWith(view)
  .instanceAs(Menu.asPopUpMenu()) 
  .setMenu(builder)
  .setOnItemClickListener(new PopUps.OnItemClickListener() {
      @Override
      public void onItemClickListener(int position, MenuItem item) {
	  Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG).show();
      }
  })
  .show();
```
Full code [here](https://github.com/tubagus216/PopUps/blob/main/app/src/main/java/dev/tubagusahmad/popups_example/MainActivity.java)

You also can contrib with this library :)
