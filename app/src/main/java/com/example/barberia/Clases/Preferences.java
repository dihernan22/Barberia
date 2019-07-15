package com.example.barberia.Clases;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Preferences {
    public static void GuardarEstado(Context context, boolean estado, String user, int id)
    {
        SharedPreferences preferences = context.getSharedPreferences("Barberia", MODE_PRIVATE);
        preferences.edit().putBoolean("estado", estado).apply();
        preferences.edit().putString("user", user).apply();
        preferences.edit().putInt("id", id).apply();
    }

    public static boolean ObtenerEstado(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences("Barberia", MODE_PRIVATE);
        return preferences.getBoolean("estado", false);
    }

    public static String ObtenerUser(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences("Barberia", MODE_PRIVATE);
        return preferences.getString("user", "");
    }

    public static int ObtenerId(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences("Barberia", MODE_PRIVATE);
        return preferences.getInt("id", 0);
    }
}
