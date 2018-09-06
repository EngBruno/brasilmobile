package com.bruno.brasil_mobile;

import com.bruno.brasil_mobile.client.Client;
import com.bruno.brasil_mobile.model.State;
import com.bruno.brasil_mobile.util.Util;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private Client client;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testCreate(){
        String res = "[{\"id\":1,\"uf\":\"AC\"},{\"id\":2,\"uf\":\"AL\"},{\"id\":3,\"uf\":\"AP\"},{\"id\":4,\"uf\":\"AM\"},{\"id\":5,\"uf\":\"BA\"},{\"id\":6,\"uf\":\"CE\"},{\"id\":7,\"uf\":\"DF\"},{\"id\":8,\"uf\":\"ES\"},{\"id\":9,\"uf\":\"GO\"},{\"id\":10,\"uf\":\"MA\"},{\"id\":11,\"uf\":\"MT\"},{\"id\":12,\"uf\":\"MS\"},{\"id\":13,\"uf\":\"MG\"},{\"id\":14,\"uf\":\"PA\"},{\"id\":15,\"uf\":\"PB\"},{\"id\":16,\"uf\":\"PR\"},{\"id\":17,\"uf\":\"PE\"},{\"id\":18,\"uf\":\"PI\"},{\"id\":19,\"uf\":\"RJ\"},{\"id\":20,\"uf\":\"RN\"},{\"id\":21,\"uf\":\"RS\"},{\"id\":22,\"uf\":\"RO\"},{\"id\":23,\"uf\":\"RR\"},{\"id\":24,\"uf\":\"SC\"},{\"id\":25,\"uf\":\"SP\"},{\"id\":26,\"uf\":\"SE\"},{\"id\":27,\"uf\":\"TO\"}]";
        List<State> list = Util.createListState(res);
        assertEquals(27, list.size());
    }

    @Test
    public void testGetListState(){

    }

}