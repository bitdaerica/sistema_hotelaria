# Requisitos Não Funcionais (RNF)


## Usabilidade:

- O sistema deve ser intuitivo e fácil de usar, mesmo para usuários com pouca experiência em tecnologia. A interface precisa ser projetada de forma simples, com menus claros e funções bem definidas para que os funcionários do hotel possam operar o sistema sem dificuldade ou treinamento extenso.

- A experiência do usuário será otimizada com a utilização de design responsivo e navegação simplificada, garantindo que o sistema seja acessível e funcional para os funcionários, independentemente da sua familiaridade com o software.

- Acessibilidade também será uma prioridade, com opções como modo escuro, tamanho de fonte ajustável, e outros recursos que garantem a facilidade de uso para pessoas com deficiência visual ou outras necessidades especiais.

- O sistema será projetado para oferecer uma curva de aprendizado mínima, com feedback visual claro (como mensagens de erro e confirmação de ação) para ajudar os usuários a entender rapidamente as interações no sistema e tomar decisões sem a necessidade de assistência constante.



## Desempenho:

- O sistema será otimizado para garantir alta performance, capaz de processar grandes volumes de dados, como reservas, consultas de disponibilidade de quartos e geração de relatórios, sem comprometer a experiência do usuário.

- Tempo de resposta: O sistema deve responder a qualquer ação do usuário (seja uma consulta, uma atualização de reserva ou o login) em menos de 3 segundos, garantindo uma experiência sem fricção e sem atrasos, especialmente em momentos de pico de operações no hotel.

- O sistema será capaz de lidar com picos de demanda sem perder a estabilidade ou a performance, utilizando algoritmos otimizados e implementando estratégias eficientes de caching e gerenciamento de memória para evitar lentidão.



## Segurança:

- Proteção de dados sensíveis será garantida com o uso de criptografia avançada, assegurando que as informações dos hóspedes, como dados pessoais e informações de pagamento, estejam sempre protegidas contra vazamentos e acessos não autorizados.

- O sistema será protegido contra ataques, utilizando as melhores práticas de segurança em desenvolvimento, como sanitização de entradas de usuário e validação rigorosa de dados.

- A segurança será auditada e atualizada regularmente, com a integração de patches de segurança automáticos e verificação constante para garantir que o sistema esteja sempre protegido contra novas ameaças.



## Escalabilidade:

- O sistema foi projetado para ser altamente escalável, com a capacidade de se adaptar facilmente ao crescimento do hotel, seja no número de hóspedes, reservas, funcionalidades ou até mesmo no número de funcionários e tipos de serviço oferecidos.

- Escalabilidade horizontal: O sistema poderá ser distribuído em múltiplos servidores ou instâncias em nuvem para distribuir a carga de trabalho e garantir que ele continue funcionando sem degradação de desempenho à medida que a demanda aumenta.

- O banco de dados será configurado para suportar particionamento de dados, o que permitirá que o sistema continue a funcionar de maneira eficiente mesmo à medida que a quantidade de dados de reservas, clientes e transações cresce exponencialmente.

- O sistema também suportará a expansão geográfica, permitindo a integração de novos hotéis ou filiais ao sistema central, com a sincronização automática de dados entre diferentes unidades, mantendo uma infraestrutura coesa e em tempo real.

- Com a infraestrutura em nuvem, o sistema pode ser dimensionado de forma elástica, permitindo o aumento ou a redução de recursos de acordo com a demanda sem a necessidade de grandes investimentos em hardware físico.

## Manutenibilidade e Suporte:

- O código-fonte do sistema deve ser bem documentado, facilitando a manutenção e o desenvolvimento de novas funcionalidades.

- O sistema deve permitir a atualização de módulos e funcionalidades sem causar interrupções no serviço.

# O sistema foi projetado com foco em usabilidade, desempenho, segurança, escalabilidade e manutenibilidade, garantindo que ele seja fácil de usar, rápido, seguro, capaz de crescer com o hotel e fácil de manter ao longo do tempo. Cada um desses requisitos não funcionais foi pensado para garantir uma experiência fluida tanto para os hóspedes quanto para os funcionários, e para suportar o crescimento e as mudanças constantes na indústria hoteleira.