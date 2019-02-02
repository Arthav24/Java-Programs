# Java-Programs
My practice and class assignments of Java

#1assignment con_1.java is for generating auto number in frame.
#2assignment con_2.java and add_st.java is fetching data from 3 tables and also entering new values.
             sql commands for #2assignment are
                  ->create table state_list(state varchar(100) primary key);
                  ->create table city_list(state varchar(100),city varchar(100) primary key,Foreign key(state) references state_list(state) on delete cascade);
                  ->create table city_village(state varchar(100),city varchar(100),village varchar(100) primary key,foreign key(city)                         references city_list(city) on delete cascade,Foreign key(state) references state_list(state) on delete cascade);
