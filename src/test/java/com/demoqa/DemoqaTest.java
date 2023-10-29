package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1600х900";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 1000;
        Configuration.holdBrowserOpen = true; //
    }


    @Test
    void successfulRegistrationFormTest() {
        open("/automation-practice-form");


        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Beloved");
        $("#userEmail").setValue("Beglov@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("89595");
        $("#dateOfBirthInput").click();
        $("#react-datepicker__month-select").$(byText("December")).click();
        $("#react-datepicker__year-select").$(byValue("1900")).click();


    }

}
