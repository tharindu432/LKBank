package ruwanpathiranatc.LKBANK.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String cardId;

    @Column(nullable = false, unique = true)
    private long cardNumber;
    private String cardHolderName;
    private Double balance;
    @CreationTimestamp
    private LocalDate iss;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private LocalDateTime exp;
    private String cvv;
    private String pin;
    private String billingAddress;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transactions> transactions;

    public Card() {
    }

    public Card(String cardId, Long cardNumber, String cardHolderName, Double balance, LocalDate iss, LocalDateTime updatedAt, LocalDateTime exp, String cvv, String pin, String billingAddress) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.balance = balance;
        this.iss = iss;
        this.updatedAt = updatedAt;
        this.exp = exp;
        this.cvv = cvv;
        this.pin = pin;
        this.billingAddress = billingAddress;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String  cardId) {
        this.cardId = cardId;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getIss() {
        return iss;
    }

    public void setIss(LocalDate iss) {
        this.iss = iss;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getExp() {
        return exp;
    }

    public void setExp(LocalDateTime exp) {
        this.exp = exp;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
}
