package com.startup.uic;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 규열 on 2018-01-24.
 */

public class Main_DrawerAdapter extends RecyclerView.Adapter<Main_DrawerAdapter.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    Category category;

    boolean bSelected = false;
    int bPosition = -1;
    boolean sSelected = false;
    int sPosition = -1;
    int selectedPosition = -1;

    ArrayList<String> bigCategory;
    ArrayList<String> mid1Category;

    public Main_DrawerAdapter(Context context, LayoutInflater inflater) {
        super();
        this.context = context;
        this.inflater = inflater;

        bigCategory = new ArrayList<>(Arrays.asList("B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8"));

        mid1Category = new ArrayList<>(Arrays.asList("B1_M1", "B1_M2", "B1_M3", "B1_M4", "B1_M5", "B1_M6", "B1_M7", "B1_M8"));
        ArrayList<String> mid1sma1Category = new ArrayList<>(Arrays.asList("B1_M1_S1", "B1_M1_S2", "B1_M1_S3", "B1_M1_S4"));
        ArrayList<String> mid1sma2Category = new ArrayList<>(Arrays.asList("B1_M2_S1", "B1_M2_S2", "B1_M2_S3", "B1_M2_S4"));
        ArrayList<String> mid1sma3Category = new ArrayList<>(Arrays.asList("B1_M3_S1", "B1_M3_S2", "B1_M3_S3", "B1_M3_S4"));
        ArrayList<String> mid1sma4Category = new ArrayList<>(Arrays.asList("B1_M4_S1", "B1_M4_S2", "B1_M4_S3", "B1_M4_S4"));
        ArrayList<String> mid1sma5Category = new ArrayList<>(Arrays.asList("B1_M5_S1", "B1_M5_S2", "B1_M5_S3", "B1_M5_S4"));
        ArrayList<String> mid1sma6Category = new ArrayList<>(Arrays.asList("B1_M6_S1", "B1_M6_S2", "B1_M6_S3", "B1_M6_S4"));
        ArrayList<String> mid1sma7Category = new ArrayList<>(Arrays.asList("B1_M7_S1", "B1_M7_S2", "B1_M7_S3", "B1_M7_S4"));
        ArrayList<String> mid1sma8Category = new ArrayList<>(Arrays.asList("B1_M8_S1", "B1_M8_S2", "B1_M8_S3", "B1_M8_S4"));

        ArrayList<String> mid2Category = new ArrayList<>(Arrays.asList("B2_M1", "B2_M2", "B2_M3", "B2_M4", "B2_M5", "B2_M6", "B2_M7", "B2_M8"));
        ArrayList<String> mid2sma1Category = new ArrayList<>(Arrays.asList("B2_M1_S1", "B2_M1_S2", "B2_M1_S3", "B2_M1_S4"));
        ArrayList<String> mid2sma2Category = new ArrayList<>(Arrays.asList("B2_M2_S1", "B2_M2_S2", "B2_M2_S3", "B2_M2_S4"));
        ArrayList<String> mid2sma3Category = new ArrayList<>(Arrays.asList("B2_M3_S1", "B2_M3_S2", "B2_M3_S3", "B2_M3_S4"));
        ArrayList<String> mid2sma4Category = new ArrayList<>(Arrays.asList("B2_M4_S1", "B2_M4_S2", "B2_M4_S3", "B2_M4_S4"));
        ArrayList<String> mid2sma5Category = new ArrayList<>(Arrays.asList("B2_M5_S1", "B2_M5_S2", "B2_M5_S3", "B2_M5_S4"));
        ArrayList<String> mid2sma6Category = new ArrayList<>(Arrays.asList("B2_M6_S1", "B2_M6_S2", "B2_M6_S3", "B2_M6_S4"));
        ArrayList<String> mid2sma7Category = new ArrayList<>(Arrays.asList("B2_M7_S1", "B2_M7_S2", "B2_M7_S3", "B2_M7_S4"));
        ArrayList<String> mid2sma8Category = new ArrayList<>(Arrays.asList("B2_M8_S1", "B2_M8_S2", "B2_M8_S3", "B2_M8_S4"));

        ArrayList<String> mid3Category = new ArrayList<>(Arrays.asList("B3_M1", "B3_M2", "B3_M3", "B3_M4", "B3_M5", "B3_M6", "B3_M7", "B3_M8"));
        ArrayList<String> mid3sma1Category = new ArrayList<>(Arrays.asList("B3_M1_S1", "B3_M1_S2", "B3_M1_S3", "B3_M1_S4"));
        ArrayList<String> mid3sma2Category = new ArrayList<>(Arrays.asList("B3_M2_S1", "B3_M2_S2", "B3_M2_S3", "B3_M2_S4"));
        ArrayList<String> mid3sma3Category = new ArrayList<>(Arrays.asList("B3_M3_S1", "B3_M3_S2", "B3_M3_S3", "B3_M3_S4"));
        ArrayList<String> mid3sma4Category = new ArrayList<>(Arrays.asList("B3_M4_S1", "B3_M4_S2", "B3_M4_S3", "B3_M4_S4"));
        ArrayList<String> mid3sma5Category = new ArrayList<>(Arrays.asList("B3_M5_S1", "B3_M5_S2", "B3_M5_S3", "B3_M5_S4"));
        ArrayList<String> mid3sma6Category = new ArrayList<>(Arrays.asList("B3_M6_S1", "B3_M6_S2", "B3_M6_S3", "B3_M6_S4"));
        ArrayList<String> mid3sma7Category = new ArrayList<>(Arrays.asList("B3_M7_S1", "B3_M7_S2", "B3_M7_S3", "B3_M7_S4"));
        ArrayList<String> mid3sma8Category = new ArrayList<>(Arrays.asList("B3_M8_S1", "B3_M8_S2", "B3_M8_S3", "B3_M8_S4"));

        ArrayList<String> mid4Category = new ArrayList<>(Arrays.asList("B4_M1", "B4_M2", "B4_M3", "B4_M4", "B4_M5", "B4_M6", "B4_M7", "B4_M8"));
        ArrayList<String> mid4sma1Category = new ArrayList<>(Arrays.asList("B4_M1_S1", "B4_M1_S2", "B4_M1_S3", "B4_M1_S4"));
        ArrayList<String> mid4sma2Category = new ArrayList<>(Arrays.asList("B4_M2_S1", "B4_M2_S2", "B4_M2_S3", "B4_M2_S4"));
        ArrayList<String> mid4sma3Category = new ArrayList<>(Arrays.asList("B4_M3_S1", "B4_M3_S2", "B4_M3_S3", "B4_M3_S4"));
        ArrayList<String> mid4sma4Category = new ArrayList<>(Arrays.asList("B4_M4_S1", "B4_M4_S2", "B4_M4_S3", "B4_M4_S4"));
        ArrayList<String> mid4sma5Category = new ArrayList<>(Arrays.asList("B4_M5_S1", "B4_M5_S2", "B4_M5_S3", "B4_M5_S4"));
        ArrayList<String> mid4sma6Category = new ArrayList<>(Arrays.asList("B4_M6_S1", "B4_M6_S2", "B4_M6_S3", "B4_M6_S4"));
        ArrayList<String> mid4sma7Category = new ArrayList<>(Arrays.asList("B4_M7_S1", "B4_M7_S2", "B4_M7_S3", "B4_M7_S4"));
        ArrayList<String> mid4sma8Category = new ArrayList<>(Arrays.asList("B4_M8_S1", "B4_M8_S2", "B4_M8_S3", "B4_M8_S4"));

        ArrayList<String> mid5Category = new ArrayList<>(Arrays.asList("B5_M1", "B5_M2", "B5_M3", "B5_M4", "B5_M5", "B5_M6", "B5_M7", "B5_M8"));
        ArrayList<String> mid5sma1Category = new ArrayList<>(Arrays.asList("B5_M1_S1", "B5_M1_S2", "B5_M1_S3", "B5_M1_S4"));
        ArrayList<String> mid5sma2Category = new ArrayList<>(Arrays.asList("B5_M2_S1", "B5_M2_S2", "B5_M2_S3", "B5_M2_S4"));
        ArrayList<String> mid5sma3Category = new ArrayList<>(Arrays.asList("B5_M3_S1", "B5_M3_S2", "B5_M3_S3", "B5_M3_S4"));
        ArrayList<String> mid5sma4Category = new ArrayList<>(Arrays.asList("B5_M4_S1", "B5_M4_S2", "B5_M4_S3", "B5_M4_S4"));
        ArrayList<String> mid5sma5Category = new ArrayList<>(Arrays.asList("B5_M5_S1", "B5_M5_S2", "B5_M5_S3", "B5_M5_S4"));
        ArrayList<String> mid5sma6Category = new ArrayList<>(Arrays.asList("B5_M6_S1", "B5_M6_S2", "B5_M6_S3", "B5_M6_S4"));
        ArrayList<String> mid5sma7Category = new ArrayList<>(Arrays.asList("B5_M7_S1", "B5_M7_S2", "B5_M7_S3", "B5_M7_S4"));
        ArrayList<String> mid5sma8Category = new ArrayList<>(Arrays.asList("B5_M8_S1", "B5_M8_S2", "B5_M8_S3", "B5_M8_S4"));

        ArrayList<String> mid6Category = new ArrayList<>(Arrays.asList("B6_M1", "B6_M2", "B6_M3", "B6_M4", "B6_M5", "B6_M6", "B6_M7", "B6_M8"));
        ArrayList<String> mid6sma1Category = new ArrayList<>(Arrays.asList("B6_M1_S1", "B6_M1_S2", "B6_M1_S3", "B6_M1_S4"));
        ArrayList<String> mid6sma2Category = new ArrayList<>(Arrays.asList("B6_M2_S1", "B6_M2_S2", "B6_M2_S3", "B6_M2_S4"));
        ArrayList<String> mid6sma3Category = new ArrayList<>(Arrays.asList("B6_M3_S1", "B6_M3_S2", "B6_M3_S3", "B6_M3_S4"));
        ArrayList<String> mid6sma4Category = new ArrayList<>(Arrays.asList("B6_M4_S1", "B6_M4_S2", "B6_M4_S3", "B6_M4_S4"));
        ArrayList<String> mid6sma5Category = new ArrayList<>(Arrays.asList("B6_M5_S1", "B6_M5_S2", "B6_M5_S3", "B6_M5_S4"));
        ArrayList<String> mid6sma6Category = new ArrayList<>(Arrays.asList("B6_M6_S1", "B6_M6_S2", "B6_M6_S3", "B6_M6_S4"));
        ArrayList<String> mid6sma7Category = new ArrayList<>(Arrays.asList("B6_M7_S1", "B6_M7_S2", "B6_M7_S3", "B6_M7_S4"));
        ArrayList<String> mid6sma8Category = new ArrayList<>(Arrays.asList("B6_M8_S1", "B6_M8_S2", "B6_M8_S3", "B6_M8_S4"));

        ArrayList<String> mid7Category = new ArrayList<>(Arrays.asList("B7_M1", "B7_M2", "B7_M3", "B7_M4", "B7_M5", "B7_M6", "B7_M7", "B7_M8"));
        ArrayList<String> mid7sma1Category = new ArrayList<>(Arrays.asList("B7_M1_S1", "B7_M1_S2", "B7_M1_S3", "B7_M1_S4"));
        ArrayList<String> mid7sma2Category = new ArrayList<>(Arrays.asList("B7_M2_S1", "B7_M2_S2", "B7_M2_S3", "B7_M2_S4"));
        ArrayList<String> mid7sma3Category = new ArrayList<>(Arrays.asList("B7_M3_S1", "B7_M3_S2", "B7_M3_S3", "B7_M3_S4"));
        ArrayList<String> mid7sma4Category = new ArrayList<>(Arrays.asList("B7_M4_S1", "B7_M4_S2", "B7_M4_S3", "B7_M4_S4"));
        ArrayList<String> mid7sma5Category = new ArrayList<>(Arrays.asList("B7_M5_S1", "B7_M5_S2", "B7_M5_S3", "B7_M5_S4"));
        ArrayList<String> mid7sma6Category = new ArrayList<>(Arrays.asList("B7_M6_S1", "B7_M6_S2", "B7_M6_S3", "B7_M6_S4"));
        ArrayList<String> mid7sma7Category = new ArrayList<>(Arrays.asList("B7_M7_S1", "B7_M7_S2", "B7_M7_S3", "B7_M7_S4"));
        ArrayList<String> mid7sma8Category = new ArrayList<>(Arrays.asList("B7_M8_S1", "B7_M8_S2", "B7_M8_S3", "B7_M8_S4"));

        ArrayList<String> mid8Category = new ArrayList<>(Arrays.asList("B8_M1", "B8_M2", "B8_M3", "B8_M4", "B8_M5", "B8_M6", "B8_M7", "B8_M8"));
        ArrayList<String> mid8sma1Category = new ArrayList<>(Arrays.asList("B8_M1_S1", "B8_M1_S2", "B8_M1_S3", "B8_M1_S4"));
        ArrayList<String> mid8sma2Category = new ArrayList<>(Arrays.asList("B8_M2_S1", "B8_M2_S2", "B8_M2_S3", "B8_M2_S4"));
        ArrayList<String> mid8sma3Category = new ArrayList<>(Arrays.asList("B8_M3_S1", "B8_M3_S2", "B8_M3_S3", "B8_M3_S4"));
        ArrayList<String> mid8sma4Category = new ArrayList<>(Arrays.asList("B8_M4_S1", "B8_M4_S2", "B8_M4_S3", "B8_M4_S4"));
        ArrayList<String> mid8sma5Category = new ArrayList<>(Arrays.asList("B8_M5_S1", "B8_M5_S2", "B8_M5_S3", "B8_M5_S4"));
        ArrayList<String> mid8sma6Category = new ArrayList<>(Arrays.asList("B8_M6_S1", "B8_M6_S2", "B8_M6_S3", "B8_M6_S4"));
        ArrayList<String> mid8sma7Category = new ArrayList<>(Arrays.asList("B8_M7_S1", "B8_M7_S2", "B8_M7_S3", "B8_M7_S4"));
        ArrayList<String> mid8sma8Category = new ArrayList<>(Arrays.asList("B8_M8_S1", "B8_M8_S2", "B8_M8_S3", "B8_M8_S4"));

        category = new Category(8, bigCategory);

        category.setMidIndex(0, 8, mid1Category);
        category.setSmaIndex(0, 0, 4, mid1sma1Category);
        category.setSmaIndex(0, 1, 4, mid1sma2Category);
        category.setSmaIndex(0, 2, 4, mid1sma3Category);
        category.setSmaIndex(0, 3, 4, mid1sma4Category);
        category.setSmaIndex(0, 4, 4, mid1sma5Category);
        category.setSmaIndex(0, 5, 4, mid1sma6Category);
        category.setSmaIndex(0, 6, 4, mid1sma7Category);
        category.setSmaIndex(0, 7, 4, mid1sma8Category);

        category.setMidIndex(1, 8, mid2Category);
        category.setSmaIndex(1, 0, 4, mid2sma1Category);
        category.setSmaIndex(1, 1, 4, mid2sma2Category);
        category.setSmaIndex(1, 2, 4, mid2sma3Category);
        category.setSmaIndex(1, 3, 4, mid2sma4Category);
        category.setSmaIndex(1, 4, 4, mid2sma5Category);
        category.setSmaIndex(1, 5, 4, mid2sma6Category);
        category.setSmaIndex(1, 6, 4, mid2sma7Category);
        category.setSmaIndex(1, 7, 4, mid2sma8Category);

        category.setMidIndex(2, 8, mid3Category);
        category.setSmaIndex(2, 0, 4, mid3sma1Category);
        category.setSmaIndex(2, 1, 4, mid3sma2Category);
        category.setSmaIndex(2, 2, 4, mid3sma3Category);
        category.setSmaIndex(2, 3, 4, mid3sma4Category);
        category.setSmaIndex(2, 4, 4, mid3sma5Category);
        category.setSmaIndex(2, 5, 4, mid3sma6Category);
        category.setSmaIndex(2, 6, 4, mid3sma7Category);
        category.setSmaIndex(2, 7, 4, mid3sma8Category);

        category.setMidIndex(3, 8, mid4Category);
        category.setSmaIndex(3, 0, 4, mid4sma1Category);
        category.setSmaIndex(3, 1, 4, mid4sma2Category);
        category.setSmaIndex(3, 2, 4, mid4sma3Category);
        category.setSmaIndex(3, 3, 4, mid4sma4Category);
        category.setSmaIndex(3, 4, 4, mid4sma5Category);
        category.setSmaIndex(3, 5, 4, mid4sma6Category);
        category.setSmaIndex(3, 6, 4, mid4sma7Category);
        category.setSmaIndex(3, 7, 4, mid4sma8Category);

        category.setMidIndex(4, 8, mid5Category);
        category.setSmaIndex(4, 0, 4, mid5sma1Category);
        category.setSmaIndex(4, 1, 4, mid5sma2Category);
        category.setSmaIndex(4, 2, 4, mid5sma3Category);
        category.setSmaIndex(4, 3, 4, mid5sma4Category);
        category.setSmaIndex(4, 4, 4, mid5sma5Category);
        category.setSmaIndex(4, 5, 4, mid5sma6Category);
        category.setSmaIndex(4, 6, 4, mid5sma7Category);
        category.setSmaIndex(4, 7, 4, mid5sma8Category);

        category.setMidIndex(5, 8, mid6Category);
        category.setSmaIndex(5, 0, 4, mid6sma1Category);
        category.setSmaIndex(5, 1, 4, mid6sma2Category);
        category.setSmaIndex(5, 2, 4, mid6sma3Category);
        category.setSmaIndex(5, 3, 4, mid6sma4Category);
        category.setSmaIndex(5, 4, 4, mid6sma5Category);
        category.setSmaIndex(5, 5, 4, mid6sma6Category);
        category.setSmaIndex(5, 6, 4, mid6sma7Category);
        category.setSmaIndex(5, 7, 4, mid6sma8Category);

        category.setMidIndex(6, 8, mid7Category);
        category.setSmaIndex(6, 0, 4, mid7sma1Category);
        category.setSmaIndex(6, 1, 4, mid7sma2Category);
        category.setSmaIndex(6, 2, 4, mid7sma3Category);
        category.setSmaIndex(6, 3, 4, mid7sma4Category);
        category.setSmaIndex(6, 4, 4, mid7sma5Category);
        category.setSmaIndex(6, 5, 4, mid7sma6Category);
        category.setSmaIndex(6, 6, 4, mid7sma7Category);
        category.setSmaIndex(6, 7, 4, mid7sma8Category);

        category.setMidIndex(7, 8, mid8Category);
        category.setSmaIndex(7, 0, 4, mid8sma1Category);
        category.setSmaIndex(7, 1, 4, mid8sma2Category);
        category.setSmaIndex(7, 2, 4, mid8sma3Category);
        category.setSmaIndex(7, 3, 4, mid8sma4Category);
        category.setSmaIndex(7, 4, 4, mid8sma5Category);
        category.setSmaIndex(7, 5, 4, mid8sma6Category);
        category.setSmaIndex(7, 6, 4, mid8sma7Category);
        category.setSmaIndex(7, 7, 4, mid8sma8Category);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (!bSelected && !sSelected) {
            holder.category.setText(category.maps.map.get(position).string);
            holder.category.setPadding(dipToPixels(32), dipToPixels(13), dipToPixels(33), dipToPixels(13));
            holder.category.setBackgroundColor(0x00000000);
            holder.category.setAlpha(1f);
            holder.category.setTextColor(Color.parseColor("#ffffff"));
        } else if (bSelected && !sSelected) {
            switch (position) {
                case 0:
                    holder.category.setText("< 모든 카테고리 보기");
                    holder.category.setPadding(dipToPixels(18), dipToPixels(13), dipToPixels(33), dipToPixels(13));
                    holder.category.setTextColor(Color.parseColor("#00c3ff"));
                    holder.category.setBackgroundColor(0x00000000);
                    break;
                case 1:
                    holder.category.setText(category.maps.map.get(bPosition).string);
                    holder.category.setBackgroundColor(Color.parseColor("#00c3ff"));
                    holder.category.setAlpha(1f);
                    holder.category.setPadding(dipToPixels(32), dipToPixels(13), dipToPixels(33), dipToPixels(13));
                    break;
                default:
                    holder.category.setText(category.maps.map.get(bPosition).map.get(position - 2).string);
                    holder.category.setBackgroundColor(0x00000000);
                    holder.category.setTextColor(Color.parseColor("#ffffff"));
                    holder.category.setPadding(dipToPixels(40), dipToPixels(13), dipToPixels(20), dipToPixels(13));
                    break;
            }
        } else if (bSelected && sSelected) {
            switch (position) {
                case 0:
                    holder.category.setText("< 모든 카테고리 보기");
                    holder.category.setPadding(dipToPixels(18), dipToPixels(13), dipToPixels(33), dipToPixels(13));
                    holder.category.setBackgroundColor(0x00000000);
                    holder.category.setTextColor(Color.parseColor("#00c3ff"));
                    break;
                case 1:
                    holder.category.setText(category.maps.map.get(bPosition).string);
                    holder.category.setBackgroundColor(0x00000000);
                    holder.category.setAlpha(0.5f);
                    holder.category.setPadding(dipToPixels(32), dipToPixels(13), dipToPixels(33), dipToPixels(13));
                    break;
                case 2:
                    holder.category.setText(category.maps.map.get(bPosition).map.get(sPosition).string);
                    holder.category.setBackgroundColor(Color.parseColor("#00c3ff"));
                    holder.category.setPadding(dipToPixels(32), dipToPixels(13), dipToPixels(33), dipToPixels(13));
                    break;
                default:
                    if(position == selectedPosition + 3) {
                        holder.category.setTextColor(Color.parseColor("#00c3ff"));
                        holder.category.setText(category.maps.map.get(bPosition).map.get(sPosition).map.get(position - 3).string);
                        holder.category.setPadding(dipToPixels(40), dipToPixels(13), dipToPixels(20), dipToPixels(13));
                        break;
                    }
                    holder.category.setTextColor(Color.parseColor("#ffffff"));
                    holder.category.setText(category.maps.map.get(bPosition).map.get(sPosition).map.get(position - 3).string);
                    holder.category.setPadding(dipToPixels(40), dipToPixels(13), dipToPixels(20), dipToPixels(13));
                    break;
            }
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.main_drawer_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        if (!bSelected && !sSelected) {
            return category.maps.map.size();
        } else if (bSelected && !sSelected) {
            return category.maps.map.get(bPosition).map.size() + 2;
        } else if (bSelected && sSelected) {
            return category.maps.map.get(bPosition).map.get(sPosition).map.size() + 3;
        }
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView category;

        public ViewHolder(final View itemView) {
            super(itemView);
            category = (TextView) itemView.findViewById(R.id.main_drawer_layout_category);
            category.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (!bSelected && !sSelected) {
                        bPosition = getAdapterPosition();
                        bSelected = true;
                    } else if (bSelected && !sSelected) {
                        if (getAdapterPosition() == 0) {
                            bPosition = -1;
                            bSelected = false;
                        } else if (getAdapterPosition() != 1) {
                            sSelected = true;
                            sPosition = getAdapterPosition() - 2;
                        }
                    } else if (bSelected && sSelected) {
                        if (getAdapterPosition() == 0) {
                            bSelected = false;
                            sSelected = false;
                            sPosition = -1;
                            bPosition = -1;
                            selectedPosition = -1;
                        } else if (getAdapterPosition() == 1) {
                            sSelected = false;
                            sPosition = -1;
                            selectedPosition = -1;
                        } else if (getAdapterPosition() != 2) {
                            Log.d("TAGTT", String.valueOf(bSelected) + String.valueOf(sSelected) + String.valueOf(bPosition) + String.valueOf(sPosition) + "");
                            selectedPosition = getAdapterPosition() - 3;
                            ((MainActivity)context).drawerLayout.closeDrawers();
                            //여기에 선택
                        }
                    }
                    notifyDataSetChanged();
                }
            });
        }

    }

    public int dipToPixels(float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

}
