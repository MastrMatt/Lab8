package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private ArrayList<City> cityList = new ArrayList<>();
    @Test
    public void testAddCity() {
        CustomList list = new CustomList(null, cityList);
        City city = new City("Edmonton", "AB");

        list.addCity(city);
        assertEquals(1, list.getCount());
    }

    @Test
    void hasCity() {
        CustomList list = new CustomList(null, cityList);
        City city = new City("Edmonton", "AB");

        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    void testDeleteCity() {
        CustomList list = new CustomList(null, cityList);
        City city = new City("Edmonton", "AB");
        list.addCity(city);

        // Verify that the city can be deleted successfully
        assertTrue(list.deleteCity(city));

        // Verify that an IllegalArgumentException is thrown if we try to delete the same city again
        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(city);
        });
    }

    @After
    void clearList() {
        cityList.clear();
    }
}
