# ProjetoMovieDB

Esse aplicativo tem como objetivo exibir estreias de filmes após conexão com a API do site [MovieDB](https://www.themoviedb.org/?language=pt-BR). 


# Tela Inicial

Na tela inicial uma lista contendo os filmes será exibido assim como seu nome e a data de estreia. 

<img src="https://user-images.githubusercontent.com/39638014/66276947-18b3e480-e86e-11e9-899a-c0ad8b780dd8.png" width="400">


# Tela de Detalhes


Após o clique em algum filme será exibido a tela de detalhes contendo informações como: Nota de avaliação conforme IMDB, nome completo do filme, tempo de duração, gêneros e sinopse. 

<img src="https://user-images.githubusercontent.com/39638014/66277125-5fa2d980-e870-11e9-89d5-9f5ee9154ec4.png" width="400">



Na tela de Detalhes ainda é possível navegar escolhendo filmes similares abaixo do texto de sinopse.

<img src="https://user-images.githubusercontent.com/39638014/66277648-e7401680-e877-11e9-86aa-94851bfd191d.png" width="400">


# Funcionalidades

Dentro da Tela de Detalhes pode conter de um a três ícones sendo exibidos na parte superior. O ícone de seta a esquerda significa voltar a tela inicial, o ícone de globo significa visitar o site do filme e por último o ícone de compartilhamento que enviará uma mensagem de texto contendo o link
da página do filme que você gostaria de compartilhar com algum contato. 
**IMPORTANTE: A exibição dos dois últimos ícones é dependente do retorno da API para serem ativos no aplicativo!!!**

## Ação de Compartilhamento

Após clique no ícone de compartilhar, um menu é exibido para que uma mensagem de texto com o endereço da página oficial do filme possa ser enviada a um contato de sua escolha.


<img src="https://user-images.githubusercontent.com/39638014/66277646-dbeceb00-e877-11e9-819d-5a6ec81215da.png" width="400">


Respectiva mensagem pronta para ser enviada a um contato escolhido. Aplicativo *[Hangouts](https://hangouts.google.com/)* utilizado como exemplo.


<img src="https://user-images.githubusercontent.com/39638014/66279240-adc2d780-e886-11e9-8612-2a08ecd5b95a.png" width="400">



## Navegação na página oficial do filme


Exibição da página do filme **Equalizer 2** aberta no navegador em um dispositivo móvel.



<img src="https://user-images.githubusercontent.com/39638014/66277652-edce8e00-e877-11e9-98b4-825cb8703660.png" width="400">



# Bibliotecas utilizadas no desenvolvimento

[Glide](https://github.com/bumptech/glide)

[Retrofit](https://square.github.io/retrofit/)

[GSON](https://github.com/google/gson)

[Logging Interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor)




# Nível de API


Android 4.4 KitKat - API 19 ou superior



# Finalidades

Este aplicativo foi construído como forma de estudo utilizando-se da linguagem de programação [Java](https://docs.oracle.com/javase/8/docs/technotes/guides/language/index.html)
voltada para [Android](https://www.android.com/intl/pt-BR_br/gms/). O aplicativo teve como objetivo conectar-se a API e retornar dados na tela inicial e de detalhes para os itens. 


# Observação

Para este projeto não fora utilizada nenhuma arquitetura definida e a separação do código foi dada por pastas contendo camadas para sua melhor organização e separação de classes. 
