CREATE TABLE perfil (  
         id int(6) NOT NULL AUTO_INCREMENT,  
         perfil varchar(20) NOT NULL,  
         PRIMARY KEY (id)  
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;  
       
CREATE TABLE usuario (  
         id int(6) NOT NULL AUTO_INCREMENT,  
         login varchar(20) NOT NULL,  
         senha varchar(20) NOT NULL,  
         PRIMARY KEY (id)  
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;  
       
CREATE TABLE usuario_perfil (  
         usuario_id int(6) NOT NULL,  
         perfil_id int(6) NOT NULL,  
         KEY usuario (usuario_id),  
         KEY perfil (perfil_id),  
         CONSTRAINT usuario FOREIGN KEY 
         (usuario_id) REFERENCES usuario (id) ON DELETE CASCADE 
          ON UPDATE CASCADE,  
         CONSTRAINT perfil FOREIGN KEY (perfil_id)
         REFERENCES perfil (id) ON DELETE CASCADE 
         ON UPDATE CASCADE  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;  