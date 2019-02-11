# estufadb
Sistema de Notificacoes do Nivel de Umidade das Plantas em uma Estufa

##Rotas da API

####Rotas de Espécies de Plantas
URL: especies-planta/

Metodo: POST 

Content-type: application/json

body:  
{

    "nome": "Nome da Espécie",
    "umidadeMinima": 66,
   	"umidadeMaxima": 77,
   	"imgUrl": "http://url-opcional.com.br"
}

#

URL: especies-planta/{id}

Metodo: GET 

Metodo: PUT

header-type: application/json 

body:

{

    "id": "12",
    "umidadeMaxima": 66.99
}

#

URL: especies-planta/{id}

Metodo: DELETE 

#
URL: especies-planta/page?page=0&linesPerPage=10&orderBy=nome&direction=asc

Metodo: GET


