# PingPongScoreBoard

## Tabela de Testes

| Abordagem                    | Rotação de Tela | Morte do Processo |
|------------------------------|-----------------|-------------------|
| remember                     | Não sobrevive   | Não sobrevive     |
| ViewModel + mutableStateOf   | Sobrevive       | Não sobrevive     |
| ViewModel + StateFlow        | Sobrevive       | Não sobrevive     |
| ViewModel + SavedStateHandle | Sobrevive       | Sobrevive         |

## Perguntas

1. Por que o ViewModel sozinho (etapas 2 e 3) não é suficiente para sobreviver à morte do
   processo, mesmo sobrevivendo à rotação de tela?

   R: Pois ele é mantido na RAM enquanto a Activity passa por mudanças de configuração, como a rotação da tela para qualquer lado. A instancia da Activity é reconstruida, porém a instância do ViewModel é mantida intacta na memória. Com a destruição do processo, essa memória é descartada pelo sistema operacional. O SavedStateHandle salva os dados em disco através de um Bundle (que localiza recursos através de chave:valor), e por isso, mesmo após o sistema descartar a memória alocada pela Activity, os dados são lidos do disco na reconstrução da Activity.

2. Qual a diferença prática entre usar mutableStateOf e StateFlow dentro do ViewModel
   nesta aplicação? Em algum momento essa diferença foi perceptível nos testes?

   R: mutableStateOf faz parte da API do Compose, enquanto StateFlow é do Kotlin Coroutines. Para o usuário, isso não tem diferença alguma. Porém, a nivel de arquitetura, é extremamente importante para manter o software desacoplado, já que ao não usar mutableSateOf, você permite que o mesmo ViewModel criado possa ser utilizado por qualquer API/Biblioteca de UI diferente do Compose.

3. Se este placar precisasse ser salvo permanentemente (mesmo após o usuário fechar o
   app e abrir dias depois), qual das quatro abordagens ainda seria insuficiente, e o que
   seria necessário adicionar?

   R: Nenhuma das abordagens seriam suficiente para satisfazer esse caso. O SavedStateHandle é temporário, e após o usuário explicitamente fechar o aplicativo, ou reiniciar o aparelho, o Bundle usado perde os atributos salvos em disco, referentes a execução anterior. Para satisfazer essa exigencia, seria necessário uma persistencia em disco destinada a permanencia dos dados, como um banco SQLite.

4. Na sua opinião, qual abordagem você usaria em produção para este placar e por quê?

   R: ViewModel + SavedStateHandle. A nivel de arquitetura, oferece desacoplamento da UI, fazendo uso das Kotlin Coroutines. A nivel de usabilidade do usuário, persiste os dados no disco mesmo após a morte do processo, que pode ser causado pelo gerênciamento do próprio sistema.