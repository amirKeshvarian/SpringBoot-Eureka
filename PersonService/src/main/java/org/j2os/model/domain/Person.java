package org.j2os.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name = "PERSON")
@Entity(name = "person")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "personSeq", sequenceName = "person_seq", allocationSize = 1)
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator = "personSeq")
    private Long personId;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String name;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String family;
}
