insert into estado (sigla, nome) values('AC','Acre');
insert into estado (sigla, nome) values('AL','Alagoas');
insert into estado (sigla, nome) values('AP','Amapá');
insert into estado (sigla, nome) values('AM','Amazonas');
insert into estado (sigla, nome) values('BA','Bahia');
insert into estado (sigla, nome) values('CE','Ceará');
insert into estado (sigla, nome) values('ES','Espírito Santo');
insert into estado (sigla, nome) values('GO','Goiás');
insert into estado (sigla, nome) values('MA','Maranhão');
insert into estado (sigla, nome) values('MT','Mato Grosso');
insert into estado (sigla, nome) values('MS','Mato Grosso do Sul');
insert into estado (sigla, nome) values('MG','Minas Gerais');
insert into estado (sigla, nome) values('PA','Pará');
insert into estado (sigla, nome) values('PB','Paraíba');
insert into estado (sigla, nome) values('DF','Distrito Federal');
insert into estado (sigla, nome) values('PR','Paraná');
insert into estado (sigla, nome) values('PI','Piauí');
insert into estado (sigla, nome) values('RJ','Rio de Janeiro');
insert into estado (sigla, nome) values('RN','Rio Grande do Norte');
insert into estado (sigla, nome) values('RS','Rio Grande do Sul');
insert into estado (sigla, nome) values('RO','Rondônia');
insert into estado (sigla, nome) values('RR','Roraima');
insert into estado (sigla, nome) values('SC','Santa Catarina');
insert into estado (sigla, nome) values('SP','São Paulo');
insert into estado (sigla, nome) values('SE','Sergipe');
insert into estado (sigla, nome) values('TO','Tocantins');


insert into municipio (codigo, nome, estado_sigla) values(15001, 'Santarém', 'PA');
insert into municipio (codigo, nome, estado_sigla) values(15002, 'Almerim', 'PA');
insert into municipio (codigo, nome, estado_sigla) values(15003, 'Monte Alegre', 'PA');
insert into municipio (codigo, nome, estado_sigla) values(15004, 'Alenquer', 'PA');

insert into usuario(nome, username, password) value('Projeto Saude Alegria', 'adminsite', '123')
insert into grupo(nome,descricao) value('administradores', 'Gupos de Adminsitradores do Sistema')
insert into usuario_grupo(usuario_id, grupo_id) value(1,1)