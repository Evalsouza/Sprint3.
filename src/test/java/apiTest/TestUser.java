//nome do pacote
package apiTest;

//Bibliotecas

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

//Classe
public class TestUser { //Inicio da classe
    // Atributos
    String ct =  "application/json";
    String id = "e98b7070-8108-4cdb-a572-7235b2f970df";
    String uriUser = "https://bookstore.toolsqa.com/Account/v1/User";

    // Funções e Metódos
    // Funções de Apoio
    public static String lerArquivoJson(String arquivoJason) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJason)));
    }

    //Função de Testes
@Test
    public void testarIncluirUser() throws IOException {
    //apontar
    String JsonBody = lerArquivoJson("src/test/resources/json/user1.json");
    String userName = "Maria";

 //codigo id   e98b7070-8108-4cdb-a572-7235b2f970df

    //realizar o Teste
    given()
            .contentType(ct)
            .log().all()
            .body(JsonBody)
    .when()
            .post(uriUser)
    .then()
            .log().all()
            .statusCode(406)
        //    .body("code", is(1204))
         //   .body("message", is("User exists!"))
         //   .body("username", is(userName))

    ;
} // fim do post


    @Test
    public void testarTokenUser() throws IOException {
            //apontar
            String JsonBody = lerArquivoJson("src/test/resources/json/user1.json");
            String userName = "Maria";
            String password = "Asd#503201";
        //realizar o Teste
        given()
                .contentType(ct)
                .log().all()
                .body(JsonBody)
        .when()
                .post("https://bookstore.toolsqa.com/Account/v1/GenerateToken")
        .then()
                .log().all()
                .statusCode(200)
           //     .body("token", is("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Ik1hcmlhIiwicGFzc3dvcmQiOiJBc2QjNTAzMjAxIiwiaWF0IjoxNjgwNjE3MjE1fQ.15J_oHnm-T6jaffTWsvt7E8oGYjSRhE2UB9as7zJGNA"))
                .body("code", is(200))
                .body("result", is("User authorized successfully."))
                .body("username", is(userName))
                .body("password", is(password))
        ;
    } // fim do post

    @Test
    public void testeConsultarUser(){
        String username = "Maria";
        String password = "Asd#503201";

    given()
            .contentType(ct)
            .log().all()
    .when()
            .get(uriUser + username)
    .then()
            .log().all()
            .statusCode(200)
            .body("username",is(username))
            .body("password", is(password));
    }

 //   @ParameterizedTest
 //   @CsvFileSource(resources = "/json/user1.json", numLinesToSkip = 1, delimiter = ',')

 //   public void testarIncluirUserCSV(String userName,
  ///                                   String password){
 //       UserBook user = new UserBook();
//        user.userName = userName;
 ////       user.password = password;
  //      Gson gson = new Gson();
//
 //       String jsonBody = gson.toJson(user);

 //       given()
 //               .contentType(ct)
//                .log().all()
 //               .body(jsonBody)
 //       .when()
 //               .post(uriUser)
 //       .then()
 //               .log().all()
 //               .statusCode(406)
 //               .body("code", is("1204"))
//                .body("message", is("User exists!"))
 //       ;
 //   }


}