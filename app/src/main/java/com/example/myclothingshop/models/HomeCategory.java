package com.example.myclothingshop.models;

public class HomeCategory {


    String name;
    String image_url;
    String type;

        public HomeCategory(){

        }

        public HomeCategory(String name,String image_url,String type){
            this.name = name;
            this.image_url = image_url;
            this.type = type;
        }

        public String getName(){
            return name;

        }

        public void setName(String name){
            this.name = name;
        }

        public String getImage_url(){
            return image_url;
        }

        public void setImage_url(String image_url){
            this.image_url = image_url;
        }

        public String getType(){
            return type;
        }

        public void setType(String type){
            this.type = type;
        }


}
