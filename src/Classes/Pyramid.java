package Classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Pyramid extends Square implements Serializable {
    private int h;

    public Pyramid(){}

    public int getH() {
        return h;
    }

    public void setH(int h) {
        if(h > 0){
            this.h = h;
        }
        else{
            this.h = 1;
        }
    }

    public Pyramid(int side, int h) {
        super(side);
        this.setH(h);
    }

    public double getApophem(){
        return Math.sqrt((Math.pow(this.side/2f, 2)) + (h*h));
    }

    public float getSquare(){
        return (float) (super.getSquare() + (2*side*getApophem()));
    }

    public float getV(){
        return (1/3f) * h * super.getSquare();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", h= " + this.getH() +
                ", apophem= " + this.getApophem() +
                ", v= " + this.getV();
    }
}
