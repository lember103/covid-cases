package de.neuefische.covidcases.api;

import de.neuefische.covidcases.model.ConfirmedByDay;
import de.neuefische.covidcases.model.api.CovidApiCountryPerDay;
import de.neuefische.covidcases.service.CovidCasesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class CovidApiServiceTest {

    @MockBean
    private CovidApiService covidApiService;

    @Autowired
    private CovidCasesService covidCasesService;


    @Test
    void test_GetCovidApiCountryPerDay_whenEmpty (){
        // GIVE
        when(covidApiService.getCovidApiCountryPerDay()).thenReturn(new CovidApiCountryPerDay[]{});

        List<ConfirmedByDay> expected = List.of();

        // WHEN
        List<ConfirmedByDay> response = covidCasesService.getConfirmedCases();

        // THEN
        assertEquals(expected, response);
    }

    @Test
    void test_GetCovidApiCountryPerDay (){

        // GIVE
        when(covidApiService.getCovidApiCountryPerDay()).thenReturn(new CovidApiCountryPerDay[]{
                new CovidApiCountryPerDay("01.01.2021", 1000),
                new CovidApiCountryPerDay("02.02.2021", 2000),
                new CovidApiCountryPerDay("03.03.2021", 3000)
        });

        List<ConfirmedByDay> expected = List.of(
                new ConfirmedByDay("01.01.2021", 1000),
                new ConfirmedByDay("02.02.2021", 2000),
                new ConfirmedByDay("03.03.2021", 3000)
        );

        // WHEN
        List<ConfirmedByDay> response = covidCasesService.getConfirmedCases();

        // THEN
        assertEquals(expected, response);
    }
}
