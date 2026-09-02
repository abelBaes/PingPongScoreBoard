# PingPongScoreBoard

## Tabela de Testes

| Abordagem                    | Rotação de Tela | Morte do Processo |
|------------------------------|-----------------|-------------------|
| remember                     | Não sobrevive   | Não sobrevive     |
| ViewModel + mutableStateOf   |                 |                   |
| ViewModel + StateFlow        |                 |                   |
| ViewModel + SavedStateHandle |                 |                   |

## Perguntas

1. Por que o ViewModel sozinho (etapas 2 e 3) não é suficiente para sobreviver à morte do
   processo, mesmo sobrevivendo à rotação de tela?

   R:

2. Qual a diferença prática entre usar mutableStateOf e StateFlow dentro do ViewModel
   nesta aplicação? Em algum momento essa diferença foi perceptível nos testes?

   R:

3. Se este placar precisasse ser salvo permanentemente (mesmo após o usuário fechar o
   app e abrir dias depois), qual das quatro abordagens ainda seria insuficiente, e o que
   seria necessário adicionar?

   R:

4. Na sua opinião, qual abordagem você usaria em produção para este placar e por quê?

   R: