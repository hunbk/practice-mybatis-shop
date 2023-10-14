insert into member value (default, 'kellogg', '123', '켈로그', 'kellogg@email.com');
insert into member value (default, 'orion', '123', '오리온', 'orion@email.com');
insert into member value (default, 'ottogi', '123', '오뚜기', 'ottogi@email.com');
insert into member value (default, 'test', '123', '테스터', 'test@email.com');

insert into item value (default, 1, '켈로그 레드베리 시리얼 에너지바', 'food', 10000, 10, '딸기, 크랜베리, 곡물 플레이크를 사용해 제조\n새콤달콤한 요거트까지 넣어 더욱 맛있는 제품\n개별 포장되어 간편하게 휴대 및 섭취가 가능', 'item1.png');
insert into item value (default, 2, '오리온 닥터유 에너지바', 'food', 20000, 15, '고소하고 바삭한 시리얼과 달콤한 초콜릿, 견과로 감싼 오리온 닥터유 에너지바에요. 오리온 닥터유 에너지바 속에는 달걀 한 개 분량의 단백질이 들어있어요. 거기에 가득 채운 견과류로 포만감이 오래도록 지속된답니다. 언제 어디서나 가지고 다니며 든든하게 영양을 채워줄 오리온 닥터유 에너지바를 만나보세요.', 'item2.jpg');
insert into item value (default, 3, '오뚜기 민트초코시럽', 'food', 30000, 20, '민초단에 합류하세요.', 'item3.jpg');
insert into item value (default, 1, '켈로그 콘푸로스트 시리얼', 'food', 15000, 12, '호랑이 기운', 'item4.jpg');

insert into cart value (4, 1, 1);
insert into cart value (4, 2, 2);

insert into favorite value (4, 1);
