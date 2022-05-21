package Classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SquaresList implements Serializable {
    private final ArrayList<Square> squareList;

    public SquaresList() {
        this.squareList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "SquaresList: " + squareList;
    }

    public boolean add(Square square) {
        return this.squareList.add(square);
    }

    public ArrayList<Square> getSquareList(){
        return this.squareList;
    }

    public void remove(int number) {
        if (number >= 0 && number < this.squareList.size()) {
            this.squareList.remove(number);
        }
    }

    public void remove(Square square) {
        this.squareList.remove(square);
    }

    public float getAvgS() {
        float sum = 0;
        for (Square square : this.squareList) {
            sum += square.getSquare();
        }
        return sum / this.squareList.size();
    }
}
