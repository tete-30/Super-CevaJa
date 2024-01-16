package cevaja.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
@Data
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "FK_pedido_usuario"), nullable = false)
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    private List<TipoCerveja> tiposCerveja = new ArrayList<>();

}
