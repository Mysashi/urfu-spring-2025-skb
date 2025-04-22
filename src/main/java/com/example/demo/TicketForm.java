package com.example.demo;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class TicketForm {

    @Size(min = 10, max = 30)
    private String title;

    public @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }

    public @Size(min = 10, max = 30) String getTitle() {
        return title;
    }

    public void setTitle(@Size(min = 10, max = 30) String title) {
        this.title = title;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    @NotNull
    private String description;

    @Email
    private String email;

}
