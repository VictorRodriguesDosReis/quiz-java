create database db_quiz;
use db_quiz;

create table tb_questao (
	cd_questao int(3) not null auto_increment,
    ds_questao varchar(250) not null,
    nm_alternativa1 varchar(50) not null,
    nm_alternativa2 varchar(50) not null,
    nm_alternativa3 varchar(50) not null,
    nm_alternativa_correta varchar(50) not null,
    constraint pk_questao
		primary key (cd_questao)
);

create table tb_jogador (
	cd_jogador int(3) not null auto_increment,
	nm_jogador varchar(20) not null,
	constraint pk_jogador
		primary key (cd_jogador)
);

create table tb_ranking (
    cd_ranking int(3) not null auto_increment,
    vl_pontuacao int not null,
    dt_criacao timestamp not null default current_timestamp(),
    cd_jogador int(3) not null,
    constraint pk_ranking
		primary key (cd_ranking),
	constraint fk_ranking_jogador
		foreign key (cd_jogador)
			references tb_jogador(cd_jogador)
);


-- PROCEDURES
delimiter $$
-- Seleciona os dados da questão solicitada
create procedure p_S_Questao(in codigo int(3))
begin
	select cd_questao, ds_questao, nm_alternativa1, nm_alternativa2, nm_alternativa3, nm_alternativa_correta
		from tb_questao where cd_questao = codigo;
end $$

-- Apresenta a quantidade de questões que tem no banco
create procedure p_S_QuantidadeQuestoes()
begin 
	select count(*) quantidadeQuestoes from tb_questao;
end $$

-- Seleciona o nome e a pontuação de todos os jogadores da maior pontuação para a menor
create procedure p_S_RankingCompleto()
begin
	select (select j.nm_jogador from tb_jogador j where j.cd_jogador = r.cd_jogador) as nm_jogador, r.vl_pontuacao, dt_criacao 
		from tb_ranking r 
			order by r.vl_pontuacao desc;
end $$

-- Insere a pontuação do jogador e o nome dele caso não exista
create procedure p_I_Jogador(in nome varchar(20), in pontuacao int)
begin
    -- Verifica se o nome do jogador já existe
    set @jogadorExiste = (select count(*) from tb_jogador where nm_jogador = nome);
    
    if @jogadorExiste > 0 then
		set @jogadorId = (select cd_jogador from tb_jogador where nm_jogador = nome);
        insert into tb_ranking(cd_jogador, vl_pontuacao) values (@jogadorId, pontuacao);
        
	else
		insert into tb_jogador(nm_jogador) values (nome);
        set @idJogador = last_insert_id();
        insert into tb_ranking(cd_jogador, vl_pontuacao) values (@idJogador, pontuacao);
        
	end if;

end $$

-- Seleciona apenas os 10 jogadores com maior pontuação
create procedure p_S_RankingParcial()
begin
	select (select j.nm_jogador from tb_jogador j where j.cd_jogador = r.cd_jogador) as nm_jogador, r.vl_pontuacao, dt_criacao 
		from tb_ranking r 
			order by r.vl_pontuacao desc limit 10; 
end $$
delimiter ;

-- INSERT QUESTÕES
INSERT INTO tb_questao (ds_questao, nm_alternativa_correta, nm_alternativa1, nm_alternativa2, nm_alternativa3) values ('Lorem ipsum dolor sit amet, consectetur adipiscing elit?', 'alternativa correta', 'alternativa 1', 'alternativa 2', 'alternativa 3');

INSERT INTO tb_questao (ds_questao, nm_alternativa_correta, nm_alternativa1, nm_alternativa2, nm_alternativa3) values ('Lorem ipsum dolor sit amet, consectetur adipiscing elit?', 'alternativa correta', 'alternativa 1', 'alternativa 2', 'alternativa 3');

INSERT INTO tb_questao (ds_questao, nm_alternativa_correta, nm_alternativa1, nm_alternativa2, nm_alternativa3) values ('Lorem ipsum dolor sit amet, consectetur adipiscing elit?', 'alternativa correta', 'alternativa 1', 'alternativa 2', 'alternativa 3');

INSERT INTO tb_questao (ds_questao, nm_alternativa_correta, nm_alternativa1, nm_alternativa2, nm_alternativa3) values ('Lorem ipsum dolor sit amet, consectetur adipiscing elit?', 'alternativa correta', 'alternativa 1', 'alternativa 2', 'alternativa 3');

INSERT INTO tb_questao (ds_questao, nm_alternativa_correta, nm_alternativa1, nm_alternativa2, nm_alternativa3) values ('Lorem ipsum dolor sit amet, consectetur adipiscing elit?', 'alternativa correta', 'alternativa 1', 'alternativa 2', 'alternativa 3');


