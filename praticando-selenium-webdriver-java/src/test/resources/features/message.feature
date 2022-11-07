#language: pt

  @mensagem
  Funcionalidade: Enviar mensagem

    @enviar-mensagem-sucesso
    Cenário: Enviar uma mensagem com sucesso
      Dado que estou na tela de contato
      E preencho todos os campo
      Quando eu clico em enviar mensagem
      Então vejo confirmação de mensagem enviada com sucesso