package org.j2os.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name = "CAR")
@Entity(name = "car")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "carSeq", sequenceName = "car_seq", allocationSize = 1)
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "carSeq")
    private Long carId;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String model;
    @Transient
    @JsonIgnore
    private Long personId;
}
