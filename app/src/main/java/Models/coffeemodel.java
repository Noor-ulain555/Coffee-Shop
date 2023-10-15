package Models;

public class coffeemodel {

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getNames() {
            return names;
        }

        public void setNames(String names) {
            this.names = names;
        }
    int image;

        String description,names,price;


        public coffeemodel(int image, String price, String description, String names) {
            this.image = image;
            this.price = price;
            this.description = description;
            this.names = names;
        }




    }


