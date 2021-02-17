package com.dev.f1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "status")
public class Status {
    @Id
    private int statusId;
    private String status;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status1 = (Status) o;
        return statusId == status1.statusId && Objects.equals(status, status1.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId, status);
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", status='" + status + '\'' +
                '}';
    }
}
