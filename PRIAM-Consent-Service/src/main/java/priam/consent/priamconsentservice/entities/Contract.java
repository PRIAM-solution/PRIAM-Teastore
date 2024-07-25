package priam.consent.priamconsentservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contract {
    @Id
    private int contractId;

    private Date signatureDate;
    private Date expirationDate;
    private int dataSubjectId;
    @Transient
    private DataSubject dataSubject;
    @JsonManagedReference
    @ToString.Exclude
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Consent> consents;


    public List<Consent> getConsent(){
        List<Consent> listConsents = null;
        for (Consent c: this.consents
             ) {
            listConsents.add(c);
        }
        return listConsents;
    }
}