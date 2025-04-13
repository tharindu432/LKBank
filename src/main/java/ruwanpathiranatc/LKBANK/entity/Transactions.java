package ruwanpathiranatc.LKBANK.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
    private String txId;
    private Long txFee;
    private String description;
    private String sender;
    private String receiver;
    private Status status;
    private Type type;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


    public Transactions() {
    }

    public Transactions(String txId, Long txFee, String description, String sender, String receiver, Status status, Type type, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.txId = txId;
        this.txFee = txFee;
        this.description = description;
        this.sender = sender;
        this.receiver = receiver;
        this.status = status;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public Long getTxFee() {
        return txFee;
    }

    public void setTxFee(Long txFee) {
        this.txFee = txFee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
