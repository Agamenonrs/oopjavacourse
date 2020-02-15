package Week1.Classes;

public class Rectangle {

    private int width, height;
    private String color = "Blue";

    public Rectangle(int width,int height){
        setWidth(width);
        setHeight(height);
    }

    public Rectangle(int width, int height, String color) {
        setWidth(width);
        setHeight(height);
        setColor(color);

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if( width > 0 ){
            this.width = width;
        }else{
            this.width = 1;
        }

    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height > 0){
            this.height = height;
        }else{
            this.height = 1;
        }

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if(color != null && color.length() > 2
                && color.length() < 20 ){
            this.color =  color.substring(0,1).toUpperCase()
                    .concat(color.substring(0).toLowerCase());
        }else{
            System.out.println("Invalid Color");
        }

    }

    public void draw(){
        for ( int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                System.out.print(color.charAt(0));
            }
            System.out.print("\n");
        }

    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                '}';
    }
}
