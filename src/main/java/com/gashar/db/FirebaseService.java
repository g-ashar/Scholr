package com.gashar.db;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.cloud.firestore.Firestore;
import com.google.api.core.ApiFuture;

import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class FirebaseService {

    public Firestore current = null;

    public void saveUserDetails(Person person) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture = current.collection("users").document(person.getUsername()).set(person);
    }

    public Person getUserDetails(String username) throws ExecutionException, InterruptedException {
        DocumentReference ref = current.collection("users").document(username);
        ApiFuture<DocumentSnapshot> future = ref.get();
        DocumentSnapshot doc = future.get();
        Person person;
        if (doc.exists()) {
            person = doc.toObject(Person.class);
            return person;
        } else {
            return null;
        }
    }

    public boolean checkUsername(String username) throws ExecutionException, InterruptedException {
        Iterable<DocumentReference> users = current.collection("users").listDocuments();
        for (DocumentReference ref: users) {
            if (Objects.equals(ref.get().get().get("username"), username)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPassword(String username, String pw) throws ExecutionException, InterruptedException {
        Person p = getUserDetails(username);
        return p.getPassword().equals(pw);
    }
}
