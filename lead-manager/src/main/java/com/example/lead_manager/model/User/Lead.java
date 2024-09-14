package com.example.lead_manager.model.User;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

import com.example.lead_manager.model.Source;
import com.example.lead_manager.model.Tag;

@Entity
@Table(name = "tb_lead")
@Data
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    private String telefone;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private Source source;
    
    @ManyToMany
    @JoinTable(
        name = "Lead_Tag",
        joinColumns = @JoinColumn(name = "lead_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
}
