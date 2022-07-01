#language:pt
  @Agi
  Funcionalidade: Pesquisa Blog Agi

    Cenario: Validar que exibe o campo de pesquisa e o botao pesquisar
      Dado que esteja na pagina inicial do blog Agi
      Quando clico na lupa da pagina inicial
      Entao valido que o campo de pesquisa e botao estao sendo exibidos

    Cenario: Realizar uma pesquisa de um valor inexistente no blog
      Dado que esteja na pagina inicial do blog Agi
      Quando clico na lupa da pagina inicial
      E pesquiso por "testestestetetsete"
      Entao exibe a mensagem "Não encontramos nada para estes termos de busca. Tente novamente com palavras-chave diferentes."

    Cenario: Realizar uma pesquisa com um valor de um titulo existente
      Dado que esteja na pagina inicial do blog Agi
      Quando clico na lupa da pagina inicial
      E pesquiso por "Tipos de Tesouro Direto: entenda a diferenca entre os titulos"
      Entao exibe somente um item

    Cenario: Realizar uma pequisa com um valor parcial de um titulo inexistente
      Dado que esteja na pagina inicial do blog Agi
      Quando clico na lupa da pagina inicial
      E pesquiso por "agi"
      Entao exibe somente mais de um item

    Cenario: Validar que ao clicar na lupa a pesquisa e o botao desaparece
      Dado que esteja na pagina inicial do blog Agi
      Quando clico na lupa da pagina inicial
      Entao valido que o campo de pesquisa e botao estao sendo exibidos
      Quando clico na lupa da pagina inicial
      Entao valido que o campo de pesquisa e botao nao estao sendo exibidos
