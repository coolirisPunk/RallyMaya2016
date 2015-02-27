package com.punkmkt.rallymaya.adapters;

        import android.content.Context;
        import android.content.Intent;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ImageView;
        import com.punkmkt.rallymaya.ParticipantesActivityDetail;
        import com.punkmkt.rallymaya.R;
        import com.punkmkt.rallymaya.models.Participante;
        import java.util.ArrayList;

public class ParticipanteAdapter  extends RecyclerView.Adapter<ParticipanteAdapter.ViewHolder> {

    private static ArrayList<Participante> participantes;
    private int itemLayout;


    public  ParticipanteAdapter(ArrayList<Participante> data,  int itemLayout){
        participantes = data;
        this.itemLayout = itemLayout;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener {
        public ImageView image;

        public ViewHolder(View itemView) {

            super(itemView);
            itemView.setOnClickListener(this);
            image = (ImageView) itemView.findViewById(R.id.image_participante);
        }

        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent;
            intent = new Intent(context, ParticipantesActivityDetail.class);
            Participante participante = participantes.get(getPosition());
            intent.putExtra("PARTICIPANTE_ID", participante.getId());
            context.startActivity(intent);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Participante participante = participantes.get(position);
        //viewHolder.name.setText(actionbar.getName());
        switch (participante.getId()){
            case 1:
                viewHolder.image.setImageResource(R.drawable.participante_1_list);
                break;
            case 2:
                viewHolder.image.setImageResource(R.drawable.participante_2_list);
                break;
            case 3:
                viewHolder.image.setImageResource(R.drawable.participante_3_list);
                break;
            case 4:
                viewHolder.image.setImageResource(R.drawable.participante_4_list);
                break;
            case 5:
                viewHolder.image.setImageResource(R.drawable.participante_5_list);
                break;
            case 6:
                viewHolder.image.setImageResource(R.drawable.participante_6_list);
                break;
            case 7:
                viewHolder.image.setImageResource(R.drawable.participante_7_list);
                break;
            case 8:
                viewHolder.image.setImageResource(R.drawable.participante_8_list);
                break;
            case 9:
                viewHolder.image.setImageResource(R.drawable.participante_9_list);
                break;
            case 10:
                viewHolder.image.setImageResource(R.drawable.participante_10_list);
                break;
            case 11:
                viewHolder.image.setImageResource(R.drawable.participante_11_list);
                break;
            case 12:
                viewHolder.image.setImageResource(R.drawable.participante_12_list);
                break;
            case 13:
                viewHolder.image.setImageResource(R.drawable.participante_13_list);
                break;
            case 14:
                viewHolder.image.setImageResource(R.drawable.participante_14_list);
                break;
            case 15:
                viewHolder.image.setImageResource(R.drawable.participante_15_list);
                break;
            case 16:
                viewHolder.image.setImageResource(R.drawable.participante_16_list);
                break;
            case 17:
                viewHolder.image.setImageResource(R.drawable.participante_17_list);
                break;
            case 18:
                viewHolder.image.setImageResource(R.drawable.participante_18_list);
                break;
            case 19:
                viewHolder.image.setImageResource(R.drawable.participante_19_list);
                break;
            case 20:
                viewHolder.image.setImageResource(R.drawable.participante_20_list);
                break;
            case 21:
                viewHolder.image.setImageResource(R.drawable.participante_21_list);
                break;
            case 22:
                viewHolder.image.setImageResource(R.drawable.participante_22_list);
                break;
            case 23:
                viewHolder.image.setImageResource(R.drawable.participante_23_list);
                break;
            case 24:
                viewHolder.image.setImageResource(R.drawable.participante_24_list);
                break;
            case 25:
                viewHolder.image.setImageResource(R.drawable.participante_25_list);
                break;
            case 26:
                viewHolder.image.setImageResource(R.drawable.participante_26_list);
                break;
        }
        viewHolder.itemView.setTag(participante);
    }


    @Override
    public int getItemCount() {
        return participantes.size();
    }

}