package Classes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.xml.crypto.Data;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DataBase {

     public static void SaveListNative(SquaresList squaresList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("./src/DataBase/" + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() + ".sq");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(squaresList);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static SquaresList LoadSquaresNative() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(Objects.requireNonNull(new File("./src/DataBase").listFiles())[Objects.requireNonNull(new File("./src/DataBase").listFiles()).length - 1]);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SquaresList squaresList = (SquaresList) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return squaresList;
    }

    public static void SaveListNative(PyramidsList pyramidsList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("./src/DataBase/" + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() + ".pyr");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(pyramidsList);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static PyramidsList LoadPyramidsNative() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(Objects.requireNonNull(new File("./src/DataBase").listFiles())[Objects.requireNonNull(new File("./src/DataBase").listFiles()).length - 2]);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        PyramidsList pyramidsList = (PyramidsList) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return pyramidsList;
    }

    public static void SaveJSON(SquaresList squaresList) throws IOException {
         ObjectMapper objectMapper = new ObjectMapper();
             objectMapper.writeValue(new File("./src/DataBaseJSON/" + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() + "S.json"), squaresList);
    }

    public static void SaveJSON(PyramidsList pyramidsList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./src/DataBaseJSON/" + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() + "P.json"), pyramidsList);
    }

    public static SquaresList LoadSquaresJSON() throws IOException {
         ObjectMapper objectMapper = new ObjectMapper();
         return objectMapper.readValue(Objects.requireNonNull(new File("./src/DataBaseJSON").listFiles())[Objects.requireNonNull(new File("./src/DataBaseJSON").listFiles()).length - 1], SquaresList.class);
    }

    public static PyramidsList LoadPyramidesJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Objects.requireNonNull(new File("./src/DataBaseJSON").listFiles())[Objects.requireNonNull(new File("./src/DataBaseJSON").listFiles()).length - 2], PyramidsList.class);
    }
}
